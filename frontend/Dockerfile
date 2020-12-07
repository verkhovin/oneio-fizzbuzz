FROM node:15.3.0-alpine3.10 as build
WORKDIR /app
COPY package*.json /app/
RUN npm install
COPY . /app
ARG configuration=development
RUN npm run build fizzbuzz-client && npm run build -- --outputPath=./dist/out --configuration $configuration

FROM nginx
EXPOSE 80
COPY --from=build /app/dist/out/ /usr/share/nginx/html
COPY /config/nginx.conf /etc/nginx/conf.d/default.conf
