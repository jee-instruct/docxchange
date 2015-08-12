<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!-- /footer -->
     <footer class="footer">
      <div class="container">
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2014 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
     
      </div>
    </footer>
    
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script> 
	<script type="text/javascript" src="<c:url value="/resources/plupload/js/plupload.full.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plupload/js/jquery.plupload.queue/jquery.plupload.queue.min.js"/>" charset="UTF-8"></script>
<script type="text/javascript" src="<c:url value="/resources/plupload/js/jquery.ui.plupload/jquery.ui.plupload.js"/>"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.0-beta.4/angular.min.js"></script>
<script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.12.0.js"></script>
<script type="text/javascript" src="<c:url value="/resources/angular-nvd3/lib/angular-mocks.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/angular-nvd3/lib/d3.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/angular-nvd3/dist/angular-nvd3.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/angular-nvd3/lib/nv.d3.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/docxchange.js"/>"></script>





<script type="text/javascript">
$(function() {
    // Setup html5 version
    $("#uploader").pluploadQueue({
        // General settings
        runtimes : 'html5,flash,silverlight,html4',
        url : "<c:url value="/file/upload"/>",
        rename : true,
        dragdrop: true,
        multiple_queues: true,
         
        filters : {
            // Maximum file size
            max_file_size : '20mb',
            // Specify what files to browse for
          //  mime_types: [
          //      {title : "Image files", extensions : "jpg,gif,png"},
          //      {title : "Zip files", extensions : "zip"}
          //  ]
        },
 
        // Resize images on clientside if we can
        resize: {
            width : 200,
            height : 200,
            quality : 90,
            crop: true // crop to exact dimensions
        },
        
        // Flash settings
        flash_swf_url : '<c:url value="/resources/plupload/js/Moxie.swf"/>',
     
        // Silverlight settings
        silverlight_xap_url : '<c:url value="/resources/plupload/js/Moxie.xap"/>',
    });
});
</script>