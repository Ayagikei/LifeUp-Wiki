; (function (win) {
    function isFunction(functionToCheck) {
        return functionToCheck && {}.toString.call(functionToCheck) === '[object Function]'
    }

    win.EditOnGithubPlugin = {}

    function create(docBase, docEditBase, title) {
        title = title || 'Edit on github'
        docEditBase = docEditBase || docBase.replace(/\/blob\//, '/edit/')

        function generateUrl(vm) {
            var docName = vm.route.file

            var editLink = ""
            if (docName) {
                editLink = docEditBase + docName
            }
            return editLink;
        }

        function generateHeader(title, url) {
            return '[:memo: ' + title + '](' + url + ')\n'
        }

        return function (hook, vm) {

            if (isFunction(title)) {
                hook.beforeEach(function (html) {
                    return generateHeader(title(vm.route.file), generateUrl(vm)) + html
                })
            } else {
                var header = generateHeader(title, generateUrl(vm))

                hook.beforeEach(function (html) {
                    return header + html
                })
            }


        }
    }

    win.EditOnGithubPlugin.create = create
})(window)