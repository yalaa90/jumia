FROM node:13.12.0-alpine
ENV PATH /app/node_modules/.bin:$PATH
COPY package.json ./
RUN npm install --silent
COPY . ./
# start app
CMD ["npm", "start"]
