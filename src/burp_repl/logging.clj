;;; Copyright © 2024 Justin Bishop <mail@dissoc.me>

(ns burp-repl.logging
  (:import (burp.api.montoya.logging Logging))
  (:require [taoensso.timbre :as timbre]))

(defn set-config [^Logging burp-logging]
  (timbre/merge-config!
   {:appenders
    {:burp {:min-level             :info
            :enabled?              true
            :async?                false
            :max-message-per-msecs nil
            :output-fn             :inherit
            :fn                    (fn [data]
                                     (->> (:vargs data)
                                          (apply str)
                                          (.logToOutput burp-logging)))}}}))
