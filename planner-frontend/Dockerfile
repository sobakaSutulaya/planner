FROM node:14.16.0-alpine as build

WORKDIR /app
COPY package.json /app/package.json

RUN npm install --only=prod
#RUN npm install react-scripts@4.0.3 -g
COPY . /app
RUN npm run build

FROM nginx:1.18.0-alpine
COPY --from=build /app/build /usr/share/nginx/html
EXPOSE 80