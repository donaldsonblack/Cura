import './index.css'
import Home from './pages/home'
import Info from './pages/info'
import Login from './pages/Login'
import { HashRouter as Router, Routes, Route } from 'react-router-dom' 
// ^ curly braces means item(s) were named in the file they're being retrieved from


function App() {

  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home/>} />
        <Route path="/info" element={<Info/>} />
        <Route path="/login" element={<Login/>} />
      </Routes>
    </Router> 
  )
}

export default App