FROM python:3.7-alpine

#执行信息
LABEL maintainer="zhangyajing@yit.com"

#工作路径设定为 code
WORKDIR /code

#创建环境变量给 Flask使用
ENV FLASK_APP app.py
ENV FLASK_RUN_HOST 0.0.0.0

#复制 app.py 到容器内 /code 目录
COPY app.py /code

#安装 gcc工具、python的依赖
RUN pip install flask && pip install redis

#映射端口
EXPOSE 5000

STOPSIGNAL SIGTERM

#为容器设置默认启动命令
CMD ["flask", "run"]
