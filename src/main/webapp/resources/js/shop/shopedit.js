$(function () {
    var registerShopUrl = '/superadmin/registershop';
    var registerUrl = '/superadmin/register';
    var shopInfoUrl = '/shop/getShopInitInfo';

    getInfo();

    function getInfo() {
        $.getJSON(shopInfoUrl, function (data) {
            if (data.success) {
                var tempCategoryHtml = '';
                data.shopCategoryList.map(function (item, index) {
                    tempCategoryHtml += '<option data-id="' + item.shopCategoryId + '">'
                        + item.shopCategoryName + '</option>';
                });
                var tempAreaHtml = '';
                data.areaList.map(function (item, index) {
                    tempAreaHtml += '<option data-id="' + item.areaId + '">'
                        + item.areaName + '</option>';
                });
                $('#shop-category').html(tempCategoryHtml);
                // $('#shop-category').attr('disabled', 'disabled');
                $('#area').html(tempAreaHtml);
                // $('#area').attr('data-id', shop.areaId);
            }
        });
    }


    $('#submit').click(function () {
        var shop = {};
        shop.shopName = $('#shop-name').val();
        shop.shopAddr = $('#shop-addr').val();
        shop.phone = $('#shop-phone').val();
        shop.shopDesc = $('#shop-desc').val();

        shop.shopCategory = {
            shopCategoryId: $('#shop-category').find('option').not(function () {
                return !this.selected;
            }).data('id')
        };
        shop.area = {
            areaId: $('#area').find('option').not(function () {
                return !this.selected;
            }).data('id')
        };

        var shopImg = $("#shop-img")[0].files[0];
        var formData = new FormData();
        formData.append('shopImg', shopImg);
        formData.append('shopStr', JSON.stringify(shop));

        var formData1 = new FormData();
        formData1.append('shopStr', JSON.stringify(shop));

        $.ajax({
            url: registerUrl,
            type: 'POST',
            // contentType: "application/x-www-form-urlencoded; charset=utf-8",
            data: formData1,
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    $.toast('提交成功！');
                    // if (isEdit){
                    //     $('#captcha_img').click();
                    // } else{
                    //     window.location.href="/shop/shoplist";
                    // }
                } else {
                    $.toast('提交失败！');
                    // $('#captcha_img').click();
                }
            }
        });

        $.ajax({
            url: registerShopUrl,
            type: 'POST',
            // contentType: "application/x-www-form-urlencoded; charset=utf-8",
            data: formData,
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    $.toast('提交成功！');
                    // if (isEdit){
                    //     $('#captcha_img').click();
                    // } else{
                    //     window.location.href="/shop/shoplist";
                    // }
                } else {
                    $.toast('提交失败！');
                    // $('#captcha_img').click();
                }
            }
        });
    });

});
