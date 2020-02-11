
var navs = [{
	"title" : "后台首页",
	"icon" : "icon-computer",
	"href" : "manage/user/main",
	"spread" : false
},{
    "title" : "就业信息管理",
    "icon" : "&#xe604;",
    "href" : "",
    "spread" : false,
    "children" : [
        {
            "title" : "三方协议列表",
            "icon" : "&#xe63c;",
            "href" : "/manage/three/three_list",
            "spread" : false
        },
        {
            "title" : "学生简历投递情况",
            "icon" : "&#xe63c;",
            "href" : "/manage/resume/resume_record_list",
            "spread" : false
        },
        {
            "title" : "学生简历列表",
            "icon" : "&#xe63c;",
            "href" : "/manage/resume/resume_list",
            "spread" : false
        },
    ]
},{
	"title" : "企业管理",
	"icon" : "&#xe60b;",
	"href" : "",
	"spread" : false,
	"children" : [
		{
			"title" : "企业列表",
			"icon" : "&#xe857;",
			"href" : "/manage/enterprise/enterprise_list_admin",
			"spread" : false
		},
		{
			"title" : "招聘职位列表",
			"icon" : "&#xe63c;",
			"href" : "/manage/job/job_list",
			"spread" : false
		},
	]
},{
    "title" : "系统管理",
    "icon" : "&#xe614;",
    "href" : "",
    "spread" : false,
    "children" : [
        {
            "title" : "学生用户管理",
            "icon" : "&#xe66f;",
            "href" : "/manage/user/student_list",
            "spread" : false
        },
        {
            "title" : "企业用户管理",
            "icon" : "&#xe612;",
            "href" : "/manage/user/enter_list",
            "spread" : false
        },
        {
            "title" : "添加学生/企业",
            "icon" : "&#xe654;",
            "href" : "/manage/user/user_add",
            "spread" : false
        },
    ]
},]

var navStudent = [{
	"title" : "后台首页",
	"icon" : "icon-computer",
	"href" : "/manage/user/studentMain",
	"spread" : false
},{
    "title" : "个人信息/简历",
    "icon" : "&#xe604;",
    "href" : "",
    "spread" : false,
    "children" : [
        {
            "title" : "我的简历",
            "icon" : "&#xe63c;",
            "href" : "/manage/resume/resume_list",
            "spread" : false
        },
        /*{
            "title" : "简历设置",
            "icon" : "&#xe63c;",
            "href" : "/manage/resume/resume_set",
            "spread" : false
        },*/
        {
            "title" : "投递简历情况",
            "icon" : "&#xe63c;",
            "href" : "/manage/resume/resume_record_list",
            "spread" : false
        },
    ]
},{
    "title" : "三方协议",
    "icon" : "&#xe705;",
    "href" : "",
    "spread" : false,
    "children" : [
        {
            "title" : "我的三方协议",
            "icon" : "&#xe67c;",
            "href" : "/manage/three/three_list",
            "spread" : false
        },
        {
            "title" : "提交三方协议",
            "icon" : "&#xe639;",
            "href" : "/manage/three/three_add",
            "spread" : false
        },

    ]
},]


var navsEnter = [{
	"title" : "后台首页",
	"icon" : "icon-computer",
	"href" : "manage/user/main",
	"spread" : false
},{
	"title" : "企业管理",
	"icon" : "&#xe60b;",
	"href" : "",
	"spread" : false,
	"children" : [
		{
			"title" : "企业信息",
			"icon" : "&#xe857;",
			"href" : "/manage/enterprise/enterprise_list",
			"spread" : false
		},
		{
			"title" : "招聘职位列表",
			"icon" : "&#xe63c;",
			"href" : "/manage/job/job_list",
			"spread" : false
		},
		{
			"title" : "毕业生投递情况",
			"icon" : "&#xe63c;",
			"href" : "/manage/resume/resume_record_enter_list",
			"spread" : false
		},
	]
}]
