# Here is the build image
FROM python:3.11.0-slim as builder
RUN apt-get update \
&& apt-get install gcc -y \
&& apt-get clean
COPY requirements.txt /app/requirements.txt
WORKDIR app
RUN pip install --user -r requirements.txt
COPY . /app
# Here is the production image
FROM python:3.11.0-slim as app
COPY --from=builder /root/.local /root/.local
COPY --from=builder /app/app/ /app/

WORKDIR app
ENV PATH=/root/.local/bin:$PATH
ENTRYPOINT uvicorn main:app --reload --host 0.0.0.0 --port 80