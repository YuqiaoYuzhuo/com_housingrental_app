//以下为修改jQuery Validation插件兼容Bootstrap的方法，没有直接写在插件中是为了便于插件升级
        $.validator.setDefaults({
            highlight: function (element) {
                $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
            },
            success: function (element) {
                element.closest('.form-group').removeClass('has-error').addClass('has-success');
            },
            errorElement: "span",
            errorPlacement: function (error, element) {
                if (element.is(":radio") || element.is(":checkbox")) {
                    error.appendTo(element.parent().parent().parent());
                } else {
                    error.appendTo(element.parent());
                }
            },
            errorClass: "help-block m-b-none",
            validClass: "help-block m-b-none"


        });

        //以下为官方示例
        $().ready(function () {

            // validate signup form on keyup and submit
            var icon = "<i class='fa fa-times-circle'></i> ";
            //修改密码表单校验
            $("#updatepasswdform").validate({
                rules: {
                    oldpasswd: {
                        required: true
                    },
                    newpassword: {
                        required: true
                    },
                    confirm_password: {
                        required: true,
                        equalTo: "#newpassword"
                    }
                },
                messages: {
                	oldpasswd: {
                         required: icon + "请输入您的原始密码"
                     },
                     newpassword: {
                        required: icon + "请输入您的新密码"
                    },
                    confirm_password: {
                        required: icon + "请再次输入密码",
                        equalTo: icon + "两次输入的密码不一致"
                    }
                }
            });
          //用户注册表单校验
            $("#userRegister").validate({
                rules: {
                	uaserAccountNum: {
                		  required: true,
                          maxlength:11,
                          minlength:11,
                          isphoneNum:true
                    },
                    userAccountPassword: {
                        required: true
                    },
                    confirm_password: {
                        required: true,
                        equalTo: "#userAccountPassword"
                    }
                },
                messages: {
                	uaserAccountNum: {
                    required:icon +"请输入手机号",
                    maxlength:icon +"请填写11位的手机号",
                    minlength:icon +"请填写11位的手机号",
                    isphoneNum:icon +"请填写正确的手机号码"
                     },
                     userAccountPassword: {
                        required: icon + "请输入密码"
                    },
                    confirm_password: {
                        required: icon + "请再次输入密码",
                        equalTo: icon + "两次输入的密码不一致"
                    }
                }
            });
        });
