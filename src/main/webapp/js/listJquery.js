$(function () {


    $("#deleteEmp").click(function () {
        //alert("delete");
        alert(window.location);
    })

    /* 新增按钮*/
    $("#addEmp").click(function () {
        findDepts();
        //弹出模态框
        $("#addEmpModal").modal({
            backdrop:"static"
        });
    })
    
    $("#saveEmp_btn").click(function () {
        $.ajax({
            url:"saveEmp",
            type:"POST",
            data:$("#save_form").serialize(),
            success:function () {
                $("#addEmpModal").modal("hide");
                alert("保存成功");
            }
        });
    })
    
    function findDepts() {
        $.ajax({
            url: "depts",
            type:"GET",
            success:function (result) {
                console.log(result);
                $("#dept_select").empty();
                $.each(result,function () {
                    var optionEle = $("<option></option>").append(this.deptName).attr("value",this.deptId);
                    optionEle.appendTo("#dept_select");
                })
                //alert($("#save_form").serialize());
            }
        });
    }

});