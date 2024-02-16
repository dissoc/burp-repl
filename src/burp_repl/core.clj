;;; Copyright © 2024 Justin Bishop <mail@dissoc.me>

(ns burp-repl.core
  (:gen-class)
  (:require [burp-repl.logging :refer [set-config]]
            [burp-repl.nrepl :as nrepl]
            [taoensso.timbre :refer [info]])
  (:import (burp.api.montoya.logging Logging)))

(defn init [api]

  ;; You will probably want to interact with the api
  ;; once you have access to repl.
  (def api-var api)

  (-> api
      .extension
      (.setName "Clojure Emacs REPL for Burp Suite"))

  ;; configure logging
  (set-config (.logging api))

  (info "Starting nREPL.")

  (let [port  (:port (nrepl/start nil))]
    (info (str "nREPL started on port " port ".")))

  (info "Use 'cider-connect' in emacs to connect."))
