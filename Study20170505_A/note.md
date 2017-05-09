1） Github网站中创建项目javastudy   https://github.com/jameswu525
	指定Public权限以及README.md
	得到Git资料库地址：https://github.com/jameswu525/javastudy.git

// 错误2） 在eclipse中右键-project-Git， 创建本地资料库
// 错误	选择本地资料库存储地址（不勾选Bare -- 空白）

2） 拷贝第一步的地址，在Git Repositories视图中右键，Paste Git URI（或者点击Clone A Git repository），下一步
	选择master，下一步选择项目文件存放目录（即开发目录）
	完成后，资料库视图中出现在线创建的项目名称的目录。
	右键属性，增加key-value user.name以及user.email，
	

3） eclipse中创建项目或者导入已有的项目（在workspace目录下），点击右键-team-share project，选择刚刚导入的Git项目。
	项目将搬进刚才资料库的本地目录中。
	右键项目，team-commit，全选Unstaged Changes，并拖入Staged Changes
	键入commit message后点击 Commit，或者Commit and Push（Commit并存入Git）
	稍后片刻，成功后查看Git项目文件。

注： 导入已存在的Git项目，同上操作，得到在线的Project后，eclipse导入已存在项目。
合作开发（Fork项目、修改后Commit、Push，Pull request给原项目作者）的方式： http://blog.csdn.net/qq_26787115/article/details/52133008

Eclipse中Help-Market，搜索需要的plugin插件后安装。


和系统相关的常用类：
1， System
	System.gc(); // 强制运行回收，以上不用的对象将被清理，  一般不用！！！
2， Runtime   -> Runtime.getRuntime.gc();

Math
abs

BigDecimal
0.01 + 0.09  // 0.09999999999999999
创建BigDecimal时建议使用String构造

