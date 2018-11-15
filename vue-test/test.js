Vue.component('todo-item', {
	props: ['todo'],
	template: '<li>{{todo.text}}</li>'
})

var app = new Vue({
	el: '#app',
	data: {
		message: 'hello Vue'
	}
});
var app2 = new Vue({
	el: '#app2',
	data: {
		message: '页面加载于 '+ new Date().toLocaleString()
	}
});
var app3 = new Vue({
	el: '#app-3',
	data: {
		seen: true
	}
});

// var app4 = new Vue({
// 	el: '#app-4'
// });
var app5 = new Vue({
	el: '#app-5',
	data: {
		groceryList: [
			{id: 0, text: '蔬菜'},
			{id: 1, text: '奶酪'},
			{id: 2, text: '苹果'},
		]
	}
})