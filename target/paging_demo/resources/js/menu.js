(function (global) {
    var menu_parrtern = "resources/snippets/menu_parttern.jsp";
    var partternCategoriesUrl = "http://localhost:8080/categories/";

    var insertHtml = function (selector, html) {
        var targetElem = document.querySelector(selector);
        targetElem.innerHTML = html;
    };

    var showLoading = function (selector) {
        var html = "<div class = 'text-center'>";
        html += "<img src = '/resources/images/ajax-loader.gif'></div>";
        insertHtml(selector, html);
    };

    var insertProperty = function (string, propName, propValue) {
        var propToReplace = "{{" + propName + "}}";
        string = string.replace(new RegExp(propToReplace, "g"), propValue);
        return string;
    };

    var loadingData = function (currentPath) {
        $.getJSON(currentPath, function (data) {
            console.log(data);
            $ajaxUtils.sendGetRequest(menu_parrtern, function (categories) {
                var finalHTml = "";
                for (var i = 0; i < data.length; i++) {
                    var html = categories;
                    var image = data[i].image;
                    var name = data[i].name;
                    html = insertProperty(html, "image", image);
                    html = insertProperty(html, "name", name);
                    finalHTml += html;
                }
                insertHtml("#menu", finalHTml);

            }, false);
        });
    }

    $("#paging li").click(function () {
        showLoading("#menu");
        var currentIndex = $(this).text();
        var currentPath = partternCategoriesUrl.concat(currentIndex);
        loadingData(currentPath);
    });


    document.addEventListener("DOMContentLoaded", function (event) {
        var defaultIndex = partternCategoriesUrl.concat(1);
        // On first load, show home view
        showLoading("#menu");
        loadingData(defaultIndex);
    });
})(window);






