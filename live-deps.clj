{:cljsbuild-out "resources/public/js/compiled/out"
 :output-dir    "resources/public/js/cljs_bundles"
 :bundles       [{:name          cljs.core
                  :require-cache [cljs.core cljs.core$macros]}
                 {:name           maria.user
                  :source-paths   ["src"]
                  :require        [[maria.user :include-macros true]]
                  :require-macros [magic-tree.backtick]
                  :provided       [maria.core]
                  :require-cache  [maria.eval]}
                 {:name     cljs.spec.alpha
                  :require  [[cljs.spec.alpha :include-macros true]
                             ;; TODO - see why the cljs.analyzer.api dependency is not found automatically
                             [cljs.analyzer.api]]
                  :provided [maria.core]}]}