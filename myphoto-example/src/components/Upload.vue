<template>
<div>
  <div>
    <div class="demo-upload-list" v-for="(item,index) in defaultList1" :key="index">
        <template>
            <img :src="item.url">
        </template>
    </div>
    <Upload
        ref="upload"
        :show-upload-list="false"
        :default-file-list="defaultList"
        :on-success="handleSuccess"
        :format="['jpg','jpeg','png']"
        :max-size="maxsize"
        :on-format-error="handleFormatError"
        :on-exceeded-size="handleMaxSize"
        :before-upload="handleBeforeUpload"
        multiple
        type="drag"
        action="http://www.ccxst.cn:8181/user/uploadimg"
        style="display: inline-block;width:58px;">
        <div style="width: 58px;height:58px;line-height: 58px;">
            <Icon type="ios-camera" size="20"></Icon>
        </div>
    </Upload>
    <Modal title="View Image" v-model="visible">
     
          <Icon color="#fff" class="leftside" type="ios-arrow-back" @click.native="leftlcon()"/>
        <img :src="'/static/' + imgName" v-if="visible" style="width: 100%">
        <Icon color="#fff" class="rightside" type="ios-arrow-forward" @click.native="rightlcon()"/>
    </Modal>
  </div>
  <div>
      <div v-if="show" class="demo-upload-list1" v-for="(item, index1) in reverseSum" :key="index1">
          <template v-if="item.status === 'finished'">
              <img :src="item.url" style="width:200px;height:200px">
              <div class="demo-upload-list-cover">
                <Icon type="ios-eye-outline" @click.native="handleView(index1,item.name)"></Icon>
                <Icon type="ios-trash-outline" @click.native="handleRemove(item)"></Icon>
            </div>
          </template>
          <template v-else>
              <Progress v-if="item.showProgress" :percent="item.percentage" hide-info></Progress>
          </template>
      </div>
  </div>
  <div class="mypage">
    <Page :total="total" :page-size="pagesize" show-elevator @on-change="onchange"/>
  </div>
</div>
</template>
<script>
export default {
  data() {
    return {
      show:true,
      defaultList: [],
      defaultList1: [
        {
            'name': 'a42bdcc1178e62b4694c830f028db5c0',
            'url': 'https://o5wwk8baw.qnssl.com/a42bdcc1178e62b4694c830f028db5c0/avatar'
        },
        {
            'name': 'bc7521e033abdd1e92222d733590f104',
            'url': 'https://o5wwk8baw.qnssl.com/bc7521e033abdd1e92222d733590f104/avatar'
        }
      ],
      imgName: "",
      visible: false,
      uploadList: [{

      }],
      currindex: '',
      maxsize: 1204,
      total: 90,
      pagesize: 5,
      currpage: 1,
    };
  },
  watch:{
    uploadList(val){
    
    }
  },
  computed: { 
    reverseSum() {
      var tmp = [];
      for(var i=0; i<this.uploadList.length;i++) {
        tmp.push(this.uploadList[i]);
      }
      return tmp.reverse();
    }
  },
  methods: {
    handleView(index1,name) {
      this.imgName = name;
      this.visible = true;
      this.currindex = index1;
    },
    handleRemove(file) {
      const fileList = this.uploadList;
      this.uploadList.splice(fileList.indexOf(file), 1);

      this.$http.post('http://www.ccxst.cn:8181/user/deletephoto',file.name).then(
        res =>{
          if(res.data.status==this.GLOBAL.SUCCESS) {
            this.$Message.success("删除成功！");
          }else {
            this.$Message.error("fail!");
          }
        }
      );
    },
    handleSuccess(res, file) {
      if (res.status == this.GLOBAL.SUCCESS) {
        this.uploadList.push({
          name: res.content,
          url: 'http://www.ccxst.cn:8088/'+res.content,
          status: "finished"
        })
        console.log(this.uploadList);
      } else {
        this.$Message.error("fail");
      };
    },
    handleFormatError(file) {
      this.$Notice.warning({
        title: "The file format is incorrect",
        desc:
          "File format of " +
          file.name +
          " is incorrect, please select jpg or png."
      });
    },
    handleMaxSize(file) {
      this.$Notice.warning({
        title: "Exceeding file size limit",
        desc: "File  " + file.name + " is too large, no more than 2M."
      });
    },
    handleBeforeUpload() {
      const check = this.uploadList.length < 1000;
      if (!check) {
        this.$Notice.warning({
          title: "Up to five pictures can be uploaded."
        });
      }
      return check;
    },
     leftlcon() {
       if(this.currindex==0) {
         this.$Message.success("当前已经是第一张啦");
       }else {
         this.currindex--;
         this.imgName=this.uploadList[this.currindex].name; 
       }
  
  },
  rightlcon() {
    if(this.currindex==this.uploadList.length) {
         this.$Message.success("当前已是最后一张啦");
       }else {
         this.currindex++;
         this.imgName=this.uploadList[this.currindex].name;
       }
  },
  onchange(val) {
    this.currpage=val;
    this.$http.post("http://www.ccxst.cn:8181/user/selectphoto",{currpage:this.currpage,pagesize:this.pagesize}).then(
      res =>{
        if(res.data.status==this.GLOBAL.SUCCESS) {
          this.total = res.data.content.count;
          this.uploadList=[];
            for(var i=0;i<res.data.content.photos.length;i++) {
            this.uploadList.push({
              status: "finished",
              name: res.data.content.photos[i].name,
              url: "http://www.ccxst.cn:8088/"+res.data.content.photos[i].name
            })
          }
        }
      }
    )
  }
  },
  mounted() {
    //  this.uploadList = this.$refs.upload.fileList;
    this.$http.post("http://www.ccxst.cn:8181/user/selectphoto",{currpage:this.currpage,pagesize:this.pagesize}).then(
      res =>{
        if(res.data.status==this.GLOBAL.SUCCESS) {
          this.total = res.data.content.count;
          for(var i=0;i<res.data.content.photos.length;i++) {
            this.uploadList.push({
              status: "finished",
              name: res.data.content.photos[i].name,
              url: "http://www.ccxst.cn:8088/"+res.data.content.photos[i].name
            })
          }
        }
      });
  }
}
</script>
<style>
 @import '../assets/css/upload.css';
</style>