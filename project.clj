(defproject bubbles "0.1.0-SNAPSHOT"
  :description "In-browser Clojurescript SOAP client library"
  :url "https://github.com/racksec/bubbles"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.122"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]

                 ;; Advanced pattern matching
                 [org.clojure/core.match "0.3.0-alpha4"]

                 ;; DOM/XML parsing/serialization
                 [hickory "0.5.4"]

                 ;; Debugging and logging
                 [com.taoensso/timbre "4.1.1"]]

  :plugins [[lein-cljsbuild "1.1.0"]
            [lein-figwheel "0.3.9"]]

  :source-paths ["src" "test"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  ;; (use 'figwheel-sidecar.repl-api) (figwheel-sidecar.repl-api/cljs-repl)

  :cljsbuild {
    :builds [{:id "dev"
              :source-paths ["src" "test"]

              :figwheel true

              :compiler {:main "bubbles.core"
                         :asset-path "js/compiled/out"
                         :output-to "resources/public/js/compiled/bubbles.js"
                         :output-dir "resources/public/js/compiled/out"
                         :optimizations :none
                         :source-map-timestamp true}}

             {:id "min"
              :source-paths ["src"]
              :compiler {:main "bubbles.core"
                         :output-to "resources/public/js/compiled/bubbles.js"
                         :optimizations :advanced
                         :pretty-print false}}

             {:id "test"
              :source-paths ["src" "test"]
              :compiler {:main "bubbles.runner"
                         :output-to "target/test.js"
                         :optimizations :whitespace
                         :pretty-print true}}]}

  :profiles {:dev {:dependencies [[doo "0.1.4"]]
                   :plugins [[lein-doo "0.1.4"]]}}

  :figwheel {:css-dirs ["resources/public/css"]
             :nrepl-port 7002})
