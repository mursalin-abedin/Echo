import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
// import Login from '../view/Login.vue'
// import Logout from '../view/Logout.vue'
// import Register from '../view/Register.vue'
import store from '../store/index'
import EditCardForm from '../components/EditCardForm'
// import Card from '../components/Card.vue'
// import CardList from '../components/CardList.vue'
import StartStudySession from '../components/StudySessionComponents/StartStudySession.vue'
import DisplayStudyCards from '../components/StudySessionComponents/DisplayStudyCards.vue'
import StudySession from "../components/StudySessionComponents/StudySession.vue"
import LandingPage from "../views/LandingPage"
import Admin from '../components/AdminSectionComponents/Admin'
import AboutUs from '../views/AboutUs.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'LandingPage',
      component: LandingPage,
      meta: {
       // requiresAuth: false,
      }
    },
    {
      path: '/home',
      name: 'Home',
      component: Home,
      meta: {
        //requiresAuth: true
      }
    },
    // {
    //   path: "/login",
    //   name: "login",
    //   component: Login,
    //   meta: {
    //     requiresAuth: false
    //   }
    // },
    // {
    //   path: "/logout",
    //   name: "logout",
    //   component: Logout,
    //   meta: {
    //     requiresAuth: false
    //   }
    // },
    // {
    //   path: "/register",
    //   name: "register",
    //   component: Register,
    //   meta: {
    //     requiresAuth: false
    //   }
    // },
    // {
    //   path: "/cards/",
    //   name: "CardList",
    //   component: CardList,
    //   meta: {
    //     requiresAuth: false
    //   }
    // },
    // {
    //   path: "/cards/:id",
    //   name: "Card",
    //   component: Card,
    //   meta: {
    //     requiresAuth: false
    //   }
    // },  
    {
      path: '/EditCard',
      name: 'EditCard',
      component: EditCardForm,
      meta: {
        //requiresAuth: true
      }
    },
    {
      path: '/StudySession',
      name: 'StartStudySession',
      component: StartStudySession,
      meta: {
        //requiresAuth: true
      }
      },
      {
        path: '/StudySession/deck/:id',
        name: 'StudySession',
        component: StudySession,
        meta: {
          // requiresAuth: true
        }
      },
      {
      path:'/DisplayStudyCards',
      name:'DisplayStudyCards',
      component: DisplayStudyCards,
      meta: {
        //requiresAuth: true  
      }
    },
    {
      path:'/Admin',
      name:'Admin',
      component: Admin,
      meta: {
        //requiresAuth: true  
      }
    },
    {
      path:'/AboutUs',
      name:'AboutUs',
      component: AboutUs,
      meta: {
        //requiresAuth: true  
      }
    },
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
