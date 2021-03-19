
$().ready(function () {
    $("#content-form").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: true,
        rules: {
            "txtTitle": {
                required: true,
                maxlength: 100,
            },
            "txtCategory": {
                required: true,
            },
            "txtTemplate": {
                required: true,
            }
        },
        messages: {
            "txtTitle": {
                required: " Title không được để trống",
                maxlength: "  Title tối đa 100 kí tự",
            },
            "txtCategory": {
                required: " Category name không được để trống",
            },
            "txtTemplate": {
                required: " Template name không được để trống",
            }
        },
        submitHandler: createNewPost
    });
});
