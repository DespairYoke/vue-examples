<template>
    <div class="main">
        <div class="head">
            <Icon type="ios-search-outline" size="35" class="glass"/>
            <Icon type="md-person" size="35" class="person"/>
        </div>
        <div class="foodmenu">
            <router-link :to="{path:'/food',query: {name: item.name} }" v-for="item in foodtypes" :key="item.id">
            <figure>
                <img :src="item.img" />
                <figcaption>{{item.name}}</figcaption>
            </figure>
            </router-link>                                    
        </div>
        <p style="height:13px;background:#F5F5F5"></p>
        <div class="foodlist">
            <shop-List>
            </shop-List>
           
        </div>
</div>
</template>
<script>
    
import shopList from '@/components/common/shoplist'
export default {
    data() {
        return {
            foodtypes: [
                {
                    name: '甜品饮料',
                    img: 'http://huluwa-test.oss-cn-hangzhou.aliyuncs.com/zwd/1.jpeg'
                },
                {
                    name: '美食',
                    img: 'http://huluwa-test.oss-cn-hangzhou.aliyuncs.com/zwd/2.jpeg'
                },
                {
                    name: '快餐',
                    img: 'http://huluwa-test.oss-cn-hangzhou.aliyuncs.com/zwd/3.jpeg'
                },
                {
                    name: '汉堡炸鸡',
                    img: 'http://huluwa-test.oss-cn-hangzhou.aliyuncs.com/zwd/5.jpeg'
                },
                {
                    name: '甜品饮料',
                    img: 'http://huluwa-test.oss-cn-hangzhou.aliyuncs.com/zwd/1.jpeg'
                },
                {
                    name: '美食',
                    img: 'http://huluwa-test.oss-cn-hangzhou.aliyuncs.com/zwd/2.jpeg'
                },
                {
                    name: '快餐',
                    img: 'http://huluwa-test.oss-cn-hangzhou.aliyuncs.com/zwd/3.jpeg'
                },
                {
                    name: '汉堡炸鸡',
                    img: 'http://huluwa-test.oss-cn-hangzhou.aliyuncs.com/zwd/5.jpeg'
                },
            ]
        }
    },
    components: {
        shopList,
    }
}
</script>
<style>
.main {
    height: 100%;
}
.head{
    height: 7%;
    background: yellow;
}
.foodmenu {
    height: 30%;
}
.foodlist {
    height: 50%
}
.glass {
    float: left;
    margin-left: 20px;
    margin-top: 10px;
}
.person {
    float: right;
    margin-right: 20px;
    margin-top: 10px;    
}
figure {
    float:left;
    font-size: 1.5em;
    margin: 5%;
    width: 15%;
    height: 25%;
}
figure img {
    height:100%;
    width: 100%;
}
figure figcaption {
    text-align: center;
    color: #000;
}
</style>


