import { createRouter, createWebHashHistory } from 'vue-router';
import Home from '../views/Home.vue';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/movies',
    name: 'Movies',
    component: () => import(/* webpackChunkName: "movies" */ '../views/movies/Movies.vue')
  },
  {
    path: '/movie/:id',
    name: 'MovieDetails',
    component: () => import(/* webpackChunkName: "movie" */ '../views/movies/MovieDetails.vue'),
    props: true
  },
  {
    path: '/add-movie',
    name: 'AddMovie',
    component: () => import(/* webpackChunkName: "addMovie" */ '../views/movies/AddMovie.vue')
  },
  {
    path: '/edit-movie/:id',
    name: 'EditMovie',
    component: () => import(/* webpackChunkName: "editMovie" */ '../views/movies/EditMovie.vue'),
    props: true
  },
  {
    path: '/actors',
    name: 'Actors',
    component: () => import(/* webpackChunkName: "actors" */ '../views/Actors.vue')
  },
  //404 catchall
  {
    path: '/:catchAll(.*)',
    name: 'NotFound',
    component: () => import(/* webpackChunkName: "notFound" */ '../views/NotFound.vue')
  }
];

const router = createRouter({
  history: createWebHashHistory(),
  routes
});

export default router;
