import Layout from './components/ui/layout'
import './index.css'
import Home from "./pages/home"
import Info from './pages/info'
import Login from './pages/Login'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom' 
// ^ curly braces means item(s) were named in the file they're being retrieved from


function App() {

  return (
    
    <Router>
      <Routes>

        <Route element={<Layout />}>
          <Route index element={<Home/>} />
          <Route path="/info" element={<Info/>} />
        </Route>
        
        <Route path="/login" element={<Login/>} />
      </Routes>
    </Router>
  )
}

export default App