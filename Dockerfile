FROM nginx:1.17.9

#执行信息
LABEL maintainer="zhangyajing@yit.com"

#创建环境变量给 Flask使用
ENV NGINX_VERSION 1.17.9
ARG work_pwd=/data/html/

#切换root用户
USER root

#执行命令，安装curl软件，设置软链接，把nginx服务的日志显示
RUN apt-get -yq update && apt-get install -y curl && \
ln -sf /dev/stdout /var/log/nginx/access.log && \
ln -sf /dev/stderr /var/log/nginx/error.log

#挂载卷
VOLUME ["/data"]

#设置工作目录
WORKDIR $work_pwd

#设置index.html文件到workdir目录下
#COPY index.html .

#映射 80 端口
EXPOSE 80

#此处CMD作为ENTRYPOINT的参数
CMD ["nginx", "-g", "daemon off;"]

STOPSIGNAL SIGRTMAX

#检测容器健康，通过访问nginx服务80端口，来判断容器服务是否正常运行
HEALTHCHECK --interval=5s --timeout=3s \
  CMD curl -fs http://localhost/ || exit 1
