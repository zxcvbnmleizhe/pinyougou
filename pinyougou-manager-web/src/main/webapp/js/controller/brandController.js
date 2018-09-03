app.controller('brandController', function($scope, $http,brandService,$controller) {

	//伪继承(1、传参要传入，2、页面要引入js)
	$controller('baseController',{$scope:$scope});


    	//进行分页查询
    	$scope.findPage = function(page,size){
    		
    		brandService.findPage().success(
    				function(response){
    					console.info("分页");
    					console.info(response);
    					$scope.list=response.row;	
    					$scope.paginationConf.totalItems=response.total;//更新总记录数
    				}			
    		);
    		
    	};
    	//新增方法·
    	$scope.add = function(){
    		if($scope.eneity.id){
    			brandService.update($scope.eneity).success(
    					function(res){
    						if(res.success){
    							$scope.reloadList();//重新加载
    						}else{
    							alert(res.message);
    						}
    					}
    			);
    			
    		}
    		else{
    			brandService.add($scope.eneity).success(
    	    			function(res){
    	    				if(res.success){
    	    					$scope.reloadList();//重新加载
    	    				}else{
    	    					alert(res.message);
    	    				}
    	    			}		
    	    		)
    			
    		}
    		
    	}
    	
    	$scope.queryOne = function(id){
    		
    		brandService.queryOne(id).success(
    				function(res){
    					console.info(res);
    					$scope.eneity = res;			
    				}
    		);
    	}


    	
    	$scope.del = function(){
    		brandService.del($scope.selectIds).success(
    				
    				function(res){
    					if(res.success){
    						$scope.reloadList();//重新加载
    					}else{
    						alert(res.message);
    					}
    					
    				}
    		)
    	}
    	//条件查询
    	$scope.queryDto = {};
    	$scope.search = function(page,size){
    		brandService.search(page,size,$scope.queryDto).success(
    				function(response){
    					console.info("条件查询")
    					console.info(response);
    					$scope.list=response.row;	
    					$scope.paginationConf.totalItems=response.total;//更新总记录数
    				}			
    		);
    		
    		
    	}
      
    });