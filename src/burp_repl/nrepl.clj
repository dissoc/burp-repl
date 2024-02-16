;;; Copyright © 2024 Justin Bishop <mail@dissoc.me>

(ns burp-repl.nrepl
  (:require
   [nrepl.server :as nrepl]))

(defn start
  [{:keys [port bind transport-fn handler ack-port greeting-fn]}]
  (try
    (nrepl/start-server :port port
                        :bind bind
                        :transport-fn transport-fn
                        :handler handler
                        :ack-port ack-port
                        :greeting-fn greeting-fn)
    (catch Throwable t
      (throw t))))

(defn stop [server]
  (nrepl/stop-server server))
