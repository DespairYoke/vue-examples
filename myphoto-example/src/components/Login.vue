<template>
    <div class="inp-box">
    <i-form ref="formInline" :model="formInline" :rules="ruleInline" >
        
        <FormItem prop="username">
            <i-input type="text" v-model="formInline.username" placeholder="请输入用户名">
                <Icon type="ios-person-outline" slot="prepend"></Icon>
            </i-input>
        </FormItem>
        <FormItem prop="password">
            <i-input type="password" v-model="formInline.password" placeholder="Password">
                <Icon type="ios-lock-outline" slot="prepend"></Icon>
            </i-input>
        </FormItem>
        <FormItem>
            <Button type="primary" @click="handleSubmit('formInline')">Signin</Button>
        </FormItem>
    </i-form>
    </div>
</template>

<script>
export default {
  data() {
    return {
      formInline: {
        username: "",
        password: ""
      },
      ruleInline: {
        username: [
          {
            required: true,
            message: "请输入用户名",
            trigger: "blur"
          }
        ],
        password: [
          {
            required: true,
            message: "请输入密码",
            trigger: "blur"
          },
          {
            type: "string",
            min: 6,
            message: "The password length cannot be less than 6 bits",
            trigger: "blur"
          }
        ]
      }
    };
  },
  methods: {
    handleSubmit(name) {
      this.$refs[name].validate(valid => {
        if (valid) {
          this.$Message.success("Success!");
          this.$router.push({
            path: "/home"
          });
        } else {
          this.$Message.error("Fail!");
        }
      });
    }
  }
};
</script>
<style>
.inp-box {
  width: 420px;
  height: 314px;
  padding-top: 57px;
  margin: 0 auto;
}
</style>