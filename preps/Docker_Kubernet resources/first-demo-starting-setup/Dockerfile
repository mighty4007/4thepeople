FROM node:14

WORKDIR /app

RUN npm config set registry https://npm.paypal.com/

COPY package.json .

RUN npm install

COPY . .

EXPOSE 3000

CMD [ "node", "app.mjs" ]docker
