FROM node

WORKDIR /myapp

RUN npm config set registry https://npm.paypal.com/

COPY . /myapp

RUN npm install

EXPOSE 80
CMD node server.js