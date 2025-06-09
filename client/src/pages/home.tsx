import { Button } from '@/components/ui/button'
import '../index.css'
import { Link } from 'react-router-dom' // using react-router-dom Link rather than <a href=""></a> prevents full page reload



function Home() {
    return (
        <>
            <h1>Home</h1>
            <div className="flex flex-wrap items-center gap-2 md:flex-row">
                <Button>
                    <Link to="/login">Login</Link>
                </Button>
            </div>
        </>
    )
}

export default Home