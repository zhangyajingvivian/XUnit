#编写dockerfile 文件，在创建镜像时去下载vim和net-tools
[root@localhost dockerfile]# cat mydockerfile 
FROM centos

ENV MYPATH /usr/local
WORKDIR $MYPATH
#设置工作目录

RUN yum -y install vim
RUN yum -y install net-tools
#安装vim和net-tools

EXPOSE 80
#开放端口

CMD echo $MYPATH
#输出工作目录
CMD echo "---end---"
CMD /bin/bash 
#进入/bin/bash目录
