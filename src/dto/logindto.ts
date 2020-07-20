export class LoginDTO {

    login: string;

    password: string;

    rememberMe: boolean;

    constructor(login: string, password: string) {
        this.login = login;
        this.password = password;
    }
}
