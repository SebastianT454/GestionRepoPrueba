# Aqui en el Dockerfile FROM, esta tomando una dependencia que en este caso es python version 3.7.11
FROM python:3.7.11-slim
# Esta es la direccion de trabajo en el cual va estar parado la maquina, basicamente hizo un cd a esta ruta.
WORKDIR  /python-api
# Hizo una copia de los archivos requirements.txt y requirements.txt dentro de la maquina local.
COPY requirements.txt requirements.txt
# Dentro de la maquina local ejecuto pip install -r requirements.txt , basicamente descargo todos los requerimientos
# Dependencias dentro de requirements (Enviorement Configuration).
RUN pip install -r requirements.txt
# Aca copia todo el contenido del directorio actual y lo copia
# a la ruta especificada como destino dentro de la imagen Docker.
COPY . .
# Aca finalmente ejecuto en la consola del sistema operativo, la ejecucion de Flask para paginas web creadas en Python.
CMD [ "python3", "-m" , "flask", "run", "--host=0.0.0.0"]
