# ETAPA 1: Usamos o Node apenas para preparar o código com o Vite
FROM node:20-alpine as build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
# Aqui o Vite entra em ação para criar a pasta 'dist'
RUN npm run build

# ETAPA 2: Usamos o Nginx para servir os arquivos que o Vite criou
FROM nginx:stable-alpine
# Copiamos o que o Vite gerou para dentro do Nginx
COPY --from=build /app/dist /usr/share/nginx/html
# Copiamos a configuração que fizemos para a API e as rotas
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
