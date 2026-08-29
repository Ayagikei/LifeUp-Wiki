;(function (win) {
  function copyText(text) {
    if (navigator.clipboard && navigator.clipboard.writeText) {
      return navigator.clipboard.writeText(text)
    }
    return new Promise(function (resolve, reject) {
      var ta = document.createElement('textarea')
      ta.value = text
      ta.setAttribute('readonly', '')
      ta.style.position = 'fixed'
      ta.style.left = '-9999px'
      document.body.appendChild(ta)
      ta.select()
      try {
        document.execCommand('copy') ? resolve() : reject(new Error('copy failed'))
      } catch (err) {
        reject(err)
      } finally {
        document.body.removeChild(ta)
      }
    })
  }

  win.CopyCodePlugin = function (hook, vm) {
    hook.doneEach(function () {
      var cfg = vm.config || {}
      var label = cfg.copyCodeLabel || 'Copy'
      var copied = cfg.copyCodeCopiedLabel || 'Copied'

      document.querySelectorAll('.markdown-section pre').forEach(function (pre) {
        if (pre.querySelector('.docsify-copy-code-button')) return

        var btn = document.createElement('button')
        btn.type = 'button'
        btn.className = 'docsify-copy-code-button'
        btn.setAttribute('aria-label', label)
        btn.textContent = label

        btn.addEventListener('click', function (event) {
          event.preventDefault()
          event.stopPropagation()
          var code = pre.querySelector('code')
          var text = (code || pre).innerText.replace(/\n$/, '')
          copyText(text)
            .then(function () {
              btn.textContent = copied
              btn.classList.add('docsify-copy-code-button--copied')
              setTimeout(function () {
                btn.textContent = label
                btn.classList.remove('docsify-copy-code-button--copied')
              }, 2000)
            })
            .catch(function () {
              btn.textContent = '…'
              setTimeout(function () {
                btn.textContent = label
              }, 2000)
            })
        })

        pre.appendChild(btn)
      })
    })
  }
})(window)
