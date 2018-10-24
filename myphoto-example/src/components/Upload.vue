<template>
<div>
  <div>
    <div class="demo-upload-list" v-for="(item,index) in uploadList" :key="index">
        <template v-if="item.status === 'finished'">
            <img :src="item.url">
        </template>
        <template v-else>
            <Progress v-if="item.showProgress" :percent="item.percentage" hide-info></Progress>
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
        action="http://localhost:8181/user/uploadimg"
        style="display: inline-block;width:58px;">
        <div style="width: 58px;height:58px;line-height: 58px;">
            <Icon type="ios-camera" size="20"></Icon>
        </div>
    </Upload>
    <Modal title="View Image" v-model="visible">
     
          <Icon color="#fff" class="leftside" type="ios-arrow-back" @click.native="leftlcon()"/>
        <img :src="'../../Images/' + imgName" v-if="visible" style="width: 100%">
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
</div>
</template>
<script>
export default {
  data() {
    return {
      show:true,
      defaultList: [
        {
          name: "1540296822827.jpg",
          url:
            "/static/1540296822827.jpg"
        },
        {
          name: "1540296822826.jpg",
          url:
            "/static/1540296822826.jpg"
        },
        {
          name: "1540296822825.jpg",
          url:
            "/static/1540296822825.jpg"
        },
        
        {
          name: "1540296822824.jpg",
          url:
            "/static/1540296822824.jpg"
        }
      ],
      imgName: "",
      visible: false,
      uploadList: [],
      currindex: '',
      maxsize: 1204
    };
  },
  watch:{
    uploadList(val){
    
    }
  },
  computed: {
    reverseSum() {
      return this.uploadList.reverse();
    }
  },
  methods: {
    handleView(index1,name) {
      this.imgName = name;
      this.visible = true;
      this.currindex = index1;
      console.log(this.currindex);
    },
    handleRemove(file) {
      const fileList = this.$refs.upload.fileList;
      this.$refs.upload.fileList.splice(fileList.indexOf(file), 1);
    },
    handleSuccess(res, file) {
      if (res.status == this.GLOBAL.SUCCESS) {
        file.name=res.content;
        file.url =res.content;
        
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
  },
  mounted() {
    this.uploadList = this.$refs.upload.fileList;
  }
}
</script>
<style>
.demo-upload-list {
  display: inline-block;
  width: 60px;
  height: 60px;
  text-align: center;
  line-height: 60px;
  border: 1px solid transparent;
  border-radius: 4px;
  overflow: hidden;
  background: #fff;
  position: relative;
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.2);
  margin-right: 4px;
}
.demo-upload-list img {
  width: 100%;
  height: 100%;
}
.demo-upload-list-cover {
  display: none;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background: rgba(0, 0, 0, 0.6);
}
.demo-upload-list:hover .demo-upload-list-cover {
  display: block;
}
.demo-upload-list-cover i {
  color: #fff;
  font-size: 28px;
  cursor: pointer;
  margin: 0 2px;
  margin-top: 40%;
}
.demo-upload-list1 {
    display: inline-block;
  text-align: center;
  overflow: hidden;
  background: #fff;
  position: relative;
  float: left;
  margin-left: 10px;
  margin-top: 50px;
}
.demo-upload-list1:hover .demo-upload-list-cover {
  display: block;
  text-align: center;
}
.leftside {
  position: absolute;
  top: 40%;
  left: -100px;
  font-size: 100px;
}
.rightside {
    position: absolute;
  top: 40%;
  right: -100px;
  font-size: 100px;
}
/* 隐藏modal提供的确定 取消 */
.ivu-btn.ivu-btn-text.ivu-btn-large,.ivu-btn.ivu-btn-primary.ivu-btn-large {
  display: none;
}
</style> 