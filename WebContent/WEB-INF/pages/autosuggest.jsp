<%@ page trimDirectiveWhitespaces="true" %>
<div class="input-group">
           <input type="text" ng-model="model" placeholder="{{prompt}}" ng-keydown="selected=false"/>
           <br/> 
<div class="items" ng-hide="!model.length || selected">
	<div class="item" ng-repeat="item in items | filter:model  track by $index" ng-click="handleSelection(item[title])" style="cursor:pointer" ng-class="{active:isCurrent($index)}" ng-mouseenter="setCurrent($index)">
		<p class="title">{{item[title]}}</p>
		<p class="subtitle">{{item[subtitle]}}</p>
	</div>
</div>  
            <div class="input-group-btn">
                <button class="btn btn-default searchButton"><i class="glyphicon glyphicon-search"></i></button>
            </div>
            
        </div>