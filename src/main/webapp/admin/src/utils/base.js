const base = {
    get() {
        return {
            url : "http://localhost:8080/ssmrt465/",
            name: "ssmrt465",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmrt465/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于个人需求和地域特色的外卖推荐系统"
        } 
    }
}
export default base
