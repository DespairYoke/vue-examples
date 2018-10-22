<template>
<div>
    <div style="height: 85px">
        <img src="../assets/logo.png" style="height: 85px"/>
    </div>
    <Menu active-name="1-2" theme="dark" width="auto" >
        <Submenu name="1">
            <template slot="title">
                <Icon type="ios-navigate"></Icon>
                    Item 1
            </template>
            <MenuItem name="1-1">
                <span @click="uploadimg">Option 1</span>
            </MenuItem>
            <MenuItem name="1-2">
                
                <span>Option 2</span>
            </MenuItem>
            <MenuItem name="1-3">
                <span>Option 3</span>
            </MenuItem>
        </Submenu>
        <Submenu name="2">
            <template slot="title">
                <Icon type="ios-keypad"></Icon>
                    Item 2
            </template>
            <MenuItem name="1-1">
                <span>Option 1</span>
            </MenuItem>
            <MenuItem name="1-2">
                <span>Option 2</span>
            </MenuItem>
            <MenuItem name="1-3">
                <span>Option 3</span>
            </MenuItem>
        </Submenu>
        <Submenu name="3">
            <template slot="title">
                <Icon type="ios-analytics"></Icon>
                    Item 3
            </template>
            <MenuItem name="1-1">
               
                <span>Option 1</span>
            </MenuItem>
            <MenuItem name="1-2">
        
                <span>Option 2</span>
            </MenuItem>
            <MenuItem name="1-3">
               
                <span>Option 3</span>
            </MenuItem>
        </Submenu>
    </Menu>
</div>
</template>
<script>
export default {

    methods: {
        uploadimg() {
            console.log("zzz")
        }
    }
}
</script>
<style>
.menu-item span{
    display: inline-block;
    overflow: hidden;
    width: 69px;
    text-overflow: ellipsis;
    white-space: nowrap;
    vertical-align: bottom;
    transition: width .2s ease .2s;
}
.menu-item i{
    transform: translateX(0px);
    transition: font-size .2s ease, transform .2s ease;
    vertical-align: middle;
    font-size: 16px;
}
.collapsed-menu span{
    width: 0px;
    transition: width .2s ease;
}
.collapsed-menu i{
    transform: translateX(5px);
    transition: font-size .2s ease .2s, transform .2s ease .2s;
    vertical-align: middle;
    font-size: 22px;
}
.ivu-layout-sider-children {
    background: #273039
}
.ivu-menu-dark {
     background: #273039 !important;
}
.layout-header-bar.ivu-layout-header {
    text-align: left;
}
</style>

