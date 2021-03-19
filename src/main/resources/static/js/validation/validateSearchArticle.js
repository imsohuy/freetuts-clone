
$().ready(function () {
    $("#content-form").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: true,
        rules: {
            "txtTitle": {
                maxlength: 100,
            },
            "txtCategory": {
                required: true,
            }
        },
        messages: {
            "txtTitle": {
                maxlength: "  Title tối đa 100 kí tự",
            },
            "txtCategory": {
                required: " Category name không được để trống",
            }
        },
    });
});
