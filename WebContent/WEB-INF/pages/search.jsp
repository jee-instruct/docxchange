<%@ page trimDirectiveWhitespaces="true" %>
<style>
 @import "http://fonts.googleapis.com/css?family=Roboto:300,400,500,700";
.search-result .thumbnail { border-radius: 0 !important; }
.search-result:first-child { margin-top: 0 !important; }
.search-result { margin-top: 20px; }
.search-result .col-md-2 { border-right: 1px dotted #ccc; min-height: 100px; }
.search-result ul { padding-left: 0 !important; list-style: none;  }
 
.search-result ul li { font: 400 normal .85em "Roboto",Arial,Verdana,sans-serif;  line-height: 30px; }
.search-result ul li i { padding-right: 5px; }
.search-result .col-md-7 { position: relative; }
.search-result h3 { font: 500 normal 1.375em "Roboto",Arial,Verdana,sans-serif; margin-top: 0 !important; margin-bottom: 10px !important; }
.search-result h3 > a, .search-result i { color: #248dc1 !important; }
.search-result p { font: normal normal 1.12em "Roboto",Arial,Verdana,sans-serif; } 
.search-result span.plus { position: absolute; right: 0; top: 126px; }
.search-result span.plus a { background-color: #248dc1; padding: 5px 5px 3px 5px; }
.search-result span.plus a:hover { background-color: #414141; }
.search-result span.plus a i { color: #fff !important; }
.search-result span.border { display: block; width: 97%; margin: 0 15px; border-bottom: 1px dotted #ccc; }
 .gi-1x{font-size: 1.5em;}
 .gi-2x{font-size: 2em;}
.gi-3x{font-size: 3em;}
.gi-4x{font-size: 4em;}
.gi-5x{font-size: 5em;}
</style>

<div ng-app="docxchange" ng-controller="autoSuggestCtrl">
<div class="jumbotron search-color drop-shadow" >

<div class='container' >
 <div class="row">
 <div class="right-inner-addon ">
    <i class="glyphicon glyphicon-search"></i>
    <input type="text" ng-model="query" ng-keyup="onKeyup()"  placeholder= "start searching...." typeahead="suggestion for suggestion in suggestions | filter:getSuggestions($viewValue)"  typeahead-loading= "loadingSymbols"  typeahead-on-select='onSelect($item, $model, $label)'  class="form-control">
</div>
         </div>
        <h6 style="margin-bottom: -25px" ng-hide="noOfHits == null" class="pull-right">About {{noOfHits}} results ({{searchTime}} seconds)</h6>
    </div>
    </div>
    
    <div class='container' ng-hide="noOfHits == null || noOfHits ==  0">
      <div class="row">
    <div class="pagination pull-right" style="margin-top: -20px">
            <ul class="pagination">
              <li ng-class="prevPageDisabled()">
                <a href ng-click="prevPage()"><span aria-hidden="true">&laquo;  Prev</span></a>
              </li>
              <li ng-repeat="n in range()" ng-class="{active: n == currentPage}" ng-click="setPage(n)">
                <a href="#">{{n+1}}</a>
              </li>
              <li ng-class="nextPageDisabled()">
                <a href ng-click="nextPage()"> <span aria-hidden="true">Next  &raquo;</span></a>
              </li>
            </ul>
          </div>
          </div>
    
    <section class="col-xs-12 col-sm-6 col-md-12">
    
    <article class="search-result row" ng-repeat="result in searchResults | offset: currentPage*itemsPerPage | limitTo: itemsPerPage">
			<!-- <div class="col-xs-12 col-sm-12 col-md-3">
				<a href="#" title="Lorem ipsum" class="thumbnail">  <img src="resources/images/Acrobat.png"/>  </a>
			</div> -->
		<!--  	<div class="col-xs-12 col-sm-12 col-md-2">
				<ul class="meta-search">
					<li></li>
					<li></li>
					<li></li>
					<li></li>
				</ul>
			</div>-->
			<div class="col-xs-12 col-sm-12 col-md-12 excerpet">
				<h3><a href="#" title="">{{result.fileName}}</a></h3>
				<p>{{result.text}}</p>		
				<div class="row">
				<div class="col-md-3">
				<i class="glyphicon glyphicon-user gi-1x"></i> <span>{{result.userIdentifier}}</span>
				</div>
				<div class="col-md-3">
				<i class="glyphicon glyphicon-calendar gi-1x"></i> <span>{{result.date}}</span>
				</div>
				<div class="col-md-3">
				<i class="glyphicon glyphicon-time gi-1x"></i> <span>{{result.time}}</span>
				</div>
				<div class="col-md-3">
				<i class="glyphicon glyphicon-download-alt gi-1x"></i><a ng-href='{{host}}{{result.fileDownloadURL}}'> <span>Download</span></a>
				</div>
				</div>				
			</div>
		</article>
    
    </section>
    <div class="row" ng-hide="noOfHits == null || noOfHits ==  0">
    <div class="pagination  pull-right">
            <ul class="pagination">
              <li ng-class="prevPageDisabled()">
                <a href ng-click="prevPage()"><span aria-hidden="true">&laquo;  Prev</span></a>
              </li>
              <li ng-repeat="n in range()" ng-class="{active: n == currentPage}" ng-click="setPage(n)">
                <a href="#">{{n+1}}</a>
              </li>
              <li ng-class="nextPageDisabled()">
                <a href ng-click="nextPage()"> <span aria-hidden="true">Next  &raquo;</span></a>
              </li>
            </ul>
          </div>
          </div>
</div>








</div>






















   

   
   
   