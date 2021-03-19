$.validator.addMethod("noSpace", function(value, element) {
  return value.indexOf(" ") < 0;
});

$().ready(function () {
    $("#content-form").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: true,
        rules: {
            "txtCategoryName": {
                required: true,
                maxlength: 50,
            },
            "txtParentCategory": {
                maxlength: 50,
            },
            "txtPath": {
                required: true,
                maxlength: 50,
                noSpace: true,
            },
        },
        messages: {
            "txtCategoryName": {
                required: " Category name không được để trống",
                maxlength: "  Category name tối đa 50 kí tự",
            },
            "txtParentCategory": {
                maxlength: "  Parent category tối đa 50 kí tự",
            },
            "txtPath": {
                required: " Post path không được để trống",
                maxlength: "  Post path tối đa 50 kí tự",
                noSpace: " Post path không được tồn tại khoảng trắng",
            },
        },
        submitHandler: createNewCategory
    });
});
