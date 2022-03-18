# MagicCards

## Descripción

Proyecto hecho en Kotlin que muestra un listado de cartas Magic y el detalle de cada una de ellas. Además, se muestra una pantalla de error si algo sale mal como quedarse sin internet en el móvil. Por último, se han incorporado animaciones con archivos Lottie.

## Sobre el proyecto

* El proyecto utiliza un patrón **MVVM** (model-view-viewmodel)
* Se ha utilizado **Material Design** para los estilos
* Las variables para definir tamaños, colores y textos están en sus ficheros oportunos
* Se han utilizado las **corrutinas** para realizar las llamadas a las funciones suspendidas que hacen una petición API 
* Hay un único MainActivity el cual tiene un **FragmentContainerView** donde se muestran los fragmentos. Cada fragmento tiene sus propios **ConstraintLayouts**
* Dispone de un componente **Navigation** que contiene toda la información con la navegación de la aplicación y establece las rutas de navegación que puede tomar el usuario
* Cada funcionalidad ha sido implementada en distintas ramas que han sido mergeadas a la rama principal del proyecto
* Dependencias utilizadas
  - Glide para cargar las imágenes de las cartas
  - Retrofit para realizar las llamadas API
  - Gson para transformar la respuestas de las llamadas en un JSON
  - RecyclerView para crear el listado de las cartas
  - Lottie para cargar los lotties de error y cargar
  - cardview para crear un diseño basado en tarjetas para el listado de las cartas

