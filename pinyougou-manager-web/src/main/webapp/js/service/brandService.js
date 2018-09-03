//服务层
    app.service('brandService',function($http){
    	this.findPage = function(page,size){
    		return $http.get('../brand/queryPage.do?page='+page+'&size='+size);
    	}
    	this.update = function(eneity){
    		return $http.post('../brand/update.do',eneity);
    	}
    	this.add = function(eneity){
    		return  $http.post('../brand/add.do',eneity);
    	}
    	this.queryOne= function(id){
    		return $http.get('../brand/queryOne.do?id='+id);
    	}
    	this.del = function(selectIds){
    		return $http.get('../brand/delete.do?ids='+selectIds);
    	}
    	this.search = function(page,size,queryDto){//这里不能写成$scope.queryDto,只需要用一个变量接收controller中的数据就可以了
    		return $http.post('../brand/queryByTiaoJian.do?page='+page+'&size='+size,queryDto);
    	}
    });