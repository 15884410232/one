/*$("#uploadfile").fileinput({

                language: 'zh', //设置语言

                uploadUrl:"http://127.0.0.1/testDemo/fileupload/upload.do", //上传的地址

               allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀

               //uploadExtraData:{"id": 1, "fileName":'123.mp3'},

                uploadAsync: true, //默认异步上传

                showUpload:true, //是否显示上传按钮

                showRemove :true, //显示移除按钮

                showPreview :true, //是否显示预览

                showCaption:false,//是否显示标题

                browseClass:"btn btn-primary", //按钮样式    

               dropZoneEnabled: false,//是否显示拖拽区域

               //minImageWidth: 50, //图片的最小宽度

               //minImageHeight: 50,//图片的最小高度

               //maxImageWidth: 1000,//图片的最大宽度

               //maxImageHeight: 1000,//图片的最大高度

                //maxFileSize:0,//单位为kb，如果为0表示不限制文件大小

               //minFileCount: 0,

                maxFileCount:10, //表示允许同时上传的最大文件个数

                enctype:'multipart/form-data',

               validateInitialCount:true,

                previewFileIcon: "<iclass='glyphicon glyphicon-king'></i>",

               msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",

           }).on("fileuploaded", function (event, data, previewId, index){

                 

});*/






//$("#imgUpload")
//        .fileinput({
//        language: 'zh',
//        uploadUrl: "/Product/imgDeal",
//        autoReplace: true,
//        maxFileCount: 1,
//        allowedFileExtensions: ["jpg", "png", "gif"],
//        browseClass: "btn btn-primary", //按钮样式 
//        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>"
//        })
//    .on("fileuploaded", function (e, data) {
//        var res = data.response;
//        if (res.state > 0) {
//            alert('上传成功');
//            alert(res.path);
//        }
//        else {
//            alert('上传失败')
//        }
//    })

function initFileInput(ctrlName,uploadUrl) {      
        var control = $('#' + ctrlName);   
        control.fileinput({  
            language: 'zh', //设置语言  
            uploadUrl: uploadUrl,  //上传地址  
            showUpload: false, //是否显示上传按钮  
            showPreview: true, //是否显示预览区域
            showRemove:true,  
             dropZoneEnabled: false,  
            //showCaption: false,//是否显示标题  
            allowedPreviewTypes: ['image'],  
                allowedFileTypes: ['image'],  
                allowedFileExtensions:  ['jpg', 'png'],  
                maxFileSize : 9000000,  
            maxFileCount: 1,  
            //initialPreview: [   
                    //预览图片的设置  
              //      "<img src='http://127.0.0.1:8080/NewsManageSys/plugin/umeditor1_2_2/jsp/upload/20161030/55061                       477813913474.jpg' class='file-preview-image' alt='肖像图片' title='肖像图片'>",  
            //],  
              
        }).on("filebatchselected", function(event, files) {  
            $(this).fileinput("upload");  
            })  
            .on("fileuploaded", function(event, data) { 
            	var res={};
            		res=data.response;
            		var sex=res.faces[0].attributes.gender.value;
            		var person=res.faces[0].attributes.ethnicity.value;
            		var age=res.faces[0].attributes.age.value;
            		if(sex=="Male"){
            			var beauty=res.faces[0].attributes.beauty.male_score;
            		}else{
            			var beauty=res.faces[0].attributes.beauty.female_score
;
            		}
            		var glass=res.faces[0].attributes.glass.value;
            		$("#sex")[0].innerHTML=sex;
            		$("#person")[0].innerHTML=person;
            		$("#age")[0].innerHTML=age;
            		$("#beauty")[0].innerHTML=beauty;
            		$("#glass")[0].innerHTML=glass;
                $("#path").attr("value",data.response);  
        });  
    }  
      var paths=window.paths;
    $(function () {  
        var path=paths+"/face";  
        initFileInput("file",path);  
          
    })  