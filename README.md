更新项目到这里，采用gradle管理
https://github.com/kana112233/translate-plugin-gradle.git

改编来自
https://gitee.com/tangyouzhi/GoogleTranslate.git

idea 全文翻译插件 会标记哪些不用翻译。
选中翻译，可以翻译所有选中的内容，当翻译完会有提示。没有翻译完会一直卡着。
专门针对markdown文件、网页文本翻译，生成文件在当前文件夹，文件名称是
翻译文件名去除后缀加上_py.md
例如
test.md
变成
test_py.md

翻译实例请看
https://github.com/kana112233/tranlate-project.git

部署文件在.idea/下面

log
第一版: 翻译选中的文字
第二版: 选中文件夹翻译
-新建action不能使用。--删除项目里面的插件，重新启动。







