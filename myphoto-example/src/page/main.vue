<template>
    <div class="layout">
        <Layout>
            <Sider ref="side1" hide-trigger collapsible :collapsed-width="78" v-model="isCollapsed">
                <MenuSider></MenuSider>
            </Sider>
            <Layout>
                <Header :style="{padding: 0}" class="layout-header-bar">
                    <Icon @click.native="collapsedSider" :class="rotateIcon" :style="{margin: '0 20px'}" type="md-menu" size="24"></Icon>
                    <span >首页</span>
                </Header>
                <Content :style="{margin: '20px', background: '#fff', minHeight: '260px'}">
                    <Upload style="margin-top:50px"></Upload>
                </Content>
            </Layout>
        </Layout>
    </div>
</template>
<script>
import MenuSider from '../components/main-sider.vue'
import Upload from '../components/Upload.vue'
    export default {
        data () {
            return {
                isCollapsed: false
            }
        },
        computed: {
            rotateIcon () {
                return [
                    'menu-icon',
                    this.isCollapsed ? 'rotate-icon' : ''
                ];
            }
        },
        methods: {
            collapsedSider () {
                this.$refs.side1.toggleCollapse();
            }
        },
        components: {
            MenuSider,
            Upload
        }
    }
</script>
<style scoped>
    .layout{
        border: 1px solid #d7dde4;
        background: #f5f7f9;
        position: absolute;
        border-radius: 4px;
        overflow: hidden;
        bottom: 0;
        top: 0;
        left: 0;
        right: 0;
       
    }
    .ivu-layout.ivu-layout-has-sider {
        width: 100%;
        height: 100%;
        /* position: absolute;
        bottom: 0;
        top: 0;
        left: ; */
    }
    .layout-header-bar{
        background: #fff;
        box-shadow: 0 1px 1px rgba(0,0,0,.1);
    }
    .layout-logo-left{
        width: 90%;
        height: 30px;
        background: #5b6270;
        border-radius: 3px;
        margin: 15px auto;
    }
    .menu-icon{
        transition: all .3s;
    }
    .rotate-icon{
        transform: rotate(-90deg);
    }

</style>