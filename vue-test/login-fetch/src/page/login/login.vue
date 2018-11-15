<template>
<div class="main">
    <Form ref="formInline" :model="userInfo"  :rules="ruleInline" :label-width="200">
        <FormItem prop="phone">
            <Input  v-model="formInline.phone" :number= "true" placeholder="phone" >
                <Icon type="ios-person-outline" slot="prepend"></Icon>
            </Input>
        </FormItem>
        <FormItem prop="password">
            <Input type="password" v-model="formInline.password" placeholder="Password">
                <Icon type="ios-lock-outline" slot="prepend"></Icon>
            </Input>
        </FormItem>
        <FormItem>
            <Button type="primary" @click="handleSubmit('formInline')">登录</Button>
            <!-- <Button type="primary" @click="handleSubmit('formInline')">注册</Button> -->
        </FormItem>
    </Form>
</div>
</template>
<script>
import {mapState,mapMutations} from 'vuex'
    export default {
        data () {
            return {
                userInfo: {  
                    phone: '',
                    password: ''
                }, //获取到的用户信息
                ruleInline: {
                    phone: [
                        {
                            required: true,type: 'number',trigger: 'blur'
                        }
                    ],
                    password: [
                        { required: true, message: '密码不能为空', trigger: 'blur' },
                        { type: 'string', min: 6, message: '密码最小为6位', trigger: 'blur' }
                    ]
                },
               
            }
        },
        methods: {
            handleSubmit(name) {
                // console.log(this.formInline)
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        console.log(this.formInline.phone)
                        this.$Message.success('Success!');
                        this.RECORD_USERINFO(this.userInfo)
                    } else {
                        this.$Message.error('Fail!');
                    }
                })
            },
            ...mapMutations([
                'RECORD_USERINFO'
            ]),
        }
    }
</script>
<style>
    .main {
        position: absolute;
        top: 35%;
        right: 35%;
    }
</style>

