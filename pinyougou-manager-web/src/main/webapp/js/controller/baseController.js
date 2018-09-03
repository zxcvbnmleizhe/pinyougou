app.controller('baseController',function ($scope) {

    //刷新列表
    $scope.reloadList = function(){
        console.info("reloadList");
        $scope.search( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    }

    //这个分页控件首先就会执行一次onchange方法
    //分页控件配置  currentPage，当前页，totalItems总记录数，perPageOptions分页选项
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function(){//当页码变更后，自动触发的方法
            /*console.log(分页);*/
            console.info("分页控件");
            $scope.reloadList();//重新加载

        }
    };

    //用户勾选
    $scope.selectIds = [];
    $scope.updateSelection = function($event,id){
        if($event.target.checked){
            $scope.selectIds.push(id);
        }else{
            var index = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(index,1);//index移除的位置，1是移除的数量

        }
    }
    
})