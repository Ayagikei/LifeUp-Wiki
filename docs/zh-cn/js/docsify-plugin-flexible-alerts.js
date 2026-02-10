(function () {
  var ALERT_MAP = {
    note: { title: "Note", color: "#3b82f6", bg: "#eff6ff" },
    tip: { title: "Tip", color: "#10b981", bg: "#ecfdf5" },
    warning: { title: "Warning", color: "#f59e0b", bg: "#fffbeb" },
    important: { title: "Important", color: "#8b5cf6", bg: "#f5f3ff" },
    attention: { title: "Attention", color: "#ef4444", bg: "#fef2f2" }
  };

  function ensureStyles() {
    if (document.getElementById("docsify-flexible-alerts-local-style")) {
      return;
    }

    var css = ""
      + ".markdown-section blockquote.docsify-alert{"
      + "margin:16px 0;padding:12px 14px;border-left:4px solid var(--alert-color,#44a8f0);"
      + "background:var(--alert-bg,#f5faff);border-radius:6px;}"
      + ".markdown-section blockquote.docsify-alert p{margin:0 0 10px;}"
      + ".markdown-section blockquote.docsify-alert p:last-child{margin-bottom:0;}"
      + ".markdown-section blockquote.docsify-alert .docsify-alert-title{font-weight:700;margin-bottom:8px;color:var(--alert-color,#44a8f0);}"
      + ".markdown-section blockquote.docsify-alert-note{--alert-color:#3b82f6;--alert-bg:#eff6ff;}"
      + ".markdown-section blockquote.docsify-alert-tip{--alert-color:#10b981;--alert-bg:#ecfdf5;}"
      + ".markdown-section blockquote.docsify-alert-warning{--alert-color:#f59e0b;--alert-bg:#fffbeb;}"
      + ".markdown-section blockquote.docsify-alert-important{--alert-color:#8b5cf6;--alert-bg:#f5f3ff;}"
      + ".markdown-section blockquote.docsify-alert-attention{--alert-color:#ef4444;--alert-bg:#fef2f2;}";

    var style = document.createElement("style");
    style.id = "docsify-flexible-alerts-local-style";
    style.textContent = css;
    document.head.appendChild(style);
  }

  function normalizeType(type) {
    if (!type) {
      return null;
    }
    var key = type.toLowerCase();
    return ALERT_MAP[key] ? key : null;
  }

  function transformCallouts(root) {
    if (!root) {
      return;
    }

    var quotes = root.querySelectorAll("blockquote");
    quotes.forEach(function (quote) {
      if (quote.classList.contains("docsify-alert")) {
        return;
      }

      var first = quote.firstElementChild;
      if (!first || first.tagName.toLowerCase() !== "p") {
        return;
      }

      var markerMatch = first.textContent.trim().match(/^\[!([A-Za-z]+)\](?:\s+(.*))?$/);
      if (!markerMatch) {
        return;
      }

      var type = normalizeType(markerMatch[1]);
      if (!type) {
        return;
      }

      var info = ALERT_MAP[type];
      quote.classList.add("docsify-alert", "docsify-alert-" + type);

      var tail = markerMatch[2];
      if (tail) {
        first.textContent = tail;
      } else {
        first.remove();
      }

      var title = document.createElement("p");
      title.className = "docsify-alert-title";
      title.textContent = info.title;
      quote.insertBefore(title, quote.firstChild);
    });
  }

  function plugin(hook) {
    hook.doneEach(function () {
      ensureStyles();
      transformCallouts(document.querySelector(".markdown-section"));
    });
  }

  window.$docsify = window.$docsify || {};
  window.$docsify.plugins = (window.$docsify.plugins || []).concat(plugin);
})();
