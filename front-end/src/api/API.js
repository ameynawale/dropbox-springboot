const api = process.env.REACT_APP_CONTACTS_API_URL || 'http://localhost:3456'

const headers = {
    'Accept': 'application/json'
};

export const doLogin = (payload) =>
    fetch(`${api}/users/dologin`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    }).then(res => {
        return res.status;
    })
        .catch(error => {
            console.log("This is error");
            return error;
        });
export const doSignup = (payload) =>
    fetch(`${api}/users/add`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    }).then(res => {
        return res.status;
    })
        .catch(error => {
            console.log("This is error");
            return error;
        });

export const editProfile = (payload) =>
    fetch(`${api}/editprofile`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    }).then(res => {
        return res.status;
    })
        .catch(error => {
            console.log("This is error");
            return error;
        });


export const doShare = (payload) =>
    fetch(`${api}/files/doShare`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        //credentials: 'include',
        //mode: 'cors',
        body: JSON.stringify(payload)
    }).then(res => {
        return res.status;
    })
        .catch(error => {
            console.log("This is error");
            return error;
        });

export const createFolder = (payload) =>
    fetch(`${api}/files/createFolder`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        //credentials: 'include',
        //mode: 'cors',
        body: JSON.stringify(payload)
    }).then(res => {
        return res.status;
    })
        .catch(error => {
            console.log("This is error");
            return error;
        });



 export const getImages = () =>
    fetch(`${api}/files/`)
        .then(res => res.json())
        .catch(error => {
            console.log("This is error.");
            return error;
        });

export const doGetList = (payload) =>
    fetch(`${api}/files/myfiles`,{
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    }).then(res => res.json())
        .catch(error => {
            console.log("This is error.");
            return error;
        });
export const doGetStar = (payload) =>
    fetch(`${api}/files/doGetStar`,{
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    }).then(res => res.json())
        .catch(error => {
            console.log("This is error.");
            return error;
        });

export const doGetFolders = (payload) =>
    fetch(`${api}/files/getfolders`,{
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    }).then(res => res.json())
        .catch(error => {
            console.log("This is error.");
            return error;
        });

export const doDelStar = (payload) =>
    fetch(`${api}/files/doDelStar`,{
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    }).then(res => res.json())
        .catch(error => {
            console.log("This is error.");
            return error;
        });
export const doStar = (payload) =>
    fetch(`${api}/files/doStar`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    }).then(res => {
        return res.status;
    })
        .catch(error => {
            console.log("This is error");
            return error;
        });

export const uploadFile = (payload) =>
    fetch(`${api}/files/upload`, {
        method: 'POST',
        body: payload
    }).then(res => res.json())
        .catch(error => {
            console.log("This is error");
            return error;
        });

export const downloadFile = (payload) =>
    fetch(`${api}/download`, {
        method: 'GET',
        body: payload
    }).then(res => {
        return res.status;
    }).catch(error => {
        console.log("This is error");
        return error;
    });

export const createGroup = (payload) =>
    fetch(`${api}/createGroup`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        //credentials: 'include',
        //mode: 'cors',
        body: JSON.stringify(payload)
    }).then(res => {
        return res.status;
    })
        .catch(error => {
            console.log("This is error");
            return error;
        });

export const logout = () =>
    fetch(`${api}/users/logout`, {
        method: 'POST',
        headers: {
            ...headers
        },
        credentials:'include'
    }).then(res => {
        return res.status;
        res.data;
    })
        .catch(error => {
            console.log("This is error");
            return error;
        });