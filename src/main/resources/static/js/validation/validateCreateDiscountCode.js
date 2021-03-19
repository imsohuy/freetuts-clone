$.validator.addMethod("noSpace", function(value, element) {
  return value.indexOf(" ") < 0;
});

$().ready(function () {
    $("#content-form").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: true,
        rules: {
            "txtDiscountName": {
                required: true,
                maxlength: 30,
            },
            "txtDiscountCode": {
                required: true,
                maxlength: 50,
            },
            "txtPercentage": {
                required: true,
                digits: true,
                min: 1,
                max: 100,
            },
            "txtDiscountLink": {
                required: true,
                maxlength: 50,
                noSpace: true,
            },
        },
        messages: {
            "txtDiscountName": {
                required: " Discount name không được để trống",
                maxlength: "  Discount name tối đa 50 kí tự",
            },
            "txtDiscountCode": {
                required: " Discount code không được để trống",
                maxlength: "  Discount code tối đa 50 kí tự",
            },
            "txtPercentage": {
                required: " Percentage không được để trống",
                digits: "  Percentage phải là số tự nhiên",
                min: " Percentage phải lớn hơn 1 và nhỏ hơn hoặc bằng 100",
                max: " Percentage phải lớn hơn 1 và nhỏ hơn hoặc bằng 100",
            },
            "txtDiscountLink": {
                required: " Discount link không được để trống",
                maxlength: "  Discount link tối đa 50 kí tự",
                noSpace: " Discount link không được tồn tại khoảng trắng",
            },
        },
        submitHandler: createNewDiscountCode
    });
});
