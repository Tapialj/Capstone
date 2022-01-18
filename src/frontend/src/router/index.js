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
    component: () => import(/* webpackChunkName: "actors" */ '../views/actors/Actors.vue')
  },
  {
    path: '/actor/:id',
    name: 'ActorDetails',
    component: () => import(/* webpackChunkName: "actor" */ '../views/actors/ActorDetails.vue'),
    props: true
  },
  {
    path: '/add-actor',
    name: 'AddActor',
    component: () => import(/* webpackChunkName: "addActor" */ '../views/actors/AddActor.vue')
  },
  {
    path: '/edit-actor/:id',
    name: "EditActor",
    component: () => import(/* webwebpackChunkName: "editActor" */ '../views/actors/EditActor.vue'),
    props: true
  },
  {
    path: '/directors',
    name: 'Directors',
    component: () => import(/* webpackChunkName: "directors" */ '../views/director/Directors.vue')
  },
  {
    path: '/director/:id',
    name: 'DirectorDetails',
    component: () => import(/* webpackChunkName: "director" */ '../views/director/DirectorDetails.vue'),
    props: true
  },
  {
    path: '/add-director',
    name: 'AddDirector',
    component: () => import(/* webpackChunkName: "addDirector" */ '../views/director/AddDirector.vue')
  },
  {
    path: '/edit-director/:id',
    name: "EditDirector",
    component: () => import(/* webwebpackChunkName: "editDirector" */ '../views/director/EditDirector.vue'),
    props: true
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
